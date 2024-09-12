import { faVideoSlash } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { Fragment, useRef } from 'react';
import { Button, Container, Form, Nav, Navbar, Offcanvas } from "react-bootstrap";
import { NavLink, useNavigate } from "react-router-dom";
import packageJson from '../../../package.json';


function Header() {
	const navigateTo = useNavigate()
	const goToPage = () => {
		navigateTo(`/${packageJson.homepage}`);
	}
	return (
		<Navbar>
			<Container fluid>
				<Navbar.Brand onClick={goToPage} style={{ "color": "gold", cursor: "pointer" }}>
					<FontAwesomeIcon icon={faVideoSlash} /> {packageJson.homepage}
				</Navbar.Brand>
				<Navbar.Toggle aria-controls="navbarScroll" />
				<Navbar.Collapse id="navbarScroll">
					<Nav className="me-auto my2 my-lg-0" style={{ maxHeight: '100px' }} navbarScroll>
						<NavLink className="nav-link" to="/">Home</NavLink>
						<NavLink className="nav-link" to="/watchList">WatchList</NavLink>
					</Nav>
					<Button variant="outline-info" className="me-2">Login</Button>
					<Button variant="outline-info" className="me-2">Register</Button>
				</Navbar.Collapse>
			</Container>
		</Navbar>
	)
}

function urlSetup(toWhere) {
	let link = `/${packageJson.homepage}`;
	if (toWhere)
		link += toWhere;
	return link;
}

function ResponsiveHeader({ setSearchPars }) {
	const searchTitle = useRef();
	// const [searchByTitle, setSearchByTitle] = useState(null);
	const navigateTo = useNavigate();

	const goToPage = (event) => {
		navigateTo(urlSetup(event.target.dataset.path));
	}

	const getRequested = () => {
		const title = searchTitle.current.value.replaceAll(/[^\w]/gm, '');
		setSearchPars({
			nameContaining: title,
			pageNo: 0,
			rowInAPage: 4,
		});
	}
	return (
		<Fragment>
			{/* Uncomment to check the responsiveness on different screens.
			{[false, 'sm', 'md', 'lg', 'xl', 'xxl'].map(expand => ( */}
			{['md'].map(expand => (
				<Navbar bg="dark" data-bs-theme="dark" key={expand} expand={expand} >
					<Container fluid>
						<Navbar.Brand onClick={goToPage} style={{ "color": "gold", cursor: "pointer" }}><FontAwesomeIcon icon={faVideoSlash} /> {packageJson.homepage}</Navbar.Brand>
						<Navbar.Toggle aria-controls={`offScreenNavbar-expand-${expand}`} />
						<Navbar.Offcanvas id={`offScreenNavbar-expand-${expand}`} bg="dark" data-bs-theme="dark"
							aria-labelledby={`offScreenNavbarLabel-expand-${expand}`}
							placement="end">
							<Offcanvas.Header closeButton>
								<Offcanvas.Title id={`offScreenNavbarLabel-expand-${expand}`}>{packageJson.homepage}</Offcanvas.Title>
							</Offcanvas.Header>
							<Offcanvas.Body>
								<Nav className="justify-content-end flex-grow-1 pe-3">
									<Nav.Link data-path="" onClick={goToPage}>Home</Nav.Link>
									<Nav.Link data-path="/request" onClick={goToPage}>Request</Nav.Link>
									<Nav.Link data-path="/contact" onClick={goToPage}>Contact</Nav.Link>
									{/* <NavDropdown title="User" id={`offScreenNavbarDropdown-expand-${expand}`}>
										<NavDropdown.Item><Button variant="outline-info" className="me-2">Login</Button></NavDropdown.Item>
										<NavDropdown.Item><Button variant="outline-info" className="me-2">Register</Button></NavDropdown.Item>
										<NavDropdown.Divider/>
										<NavDropdown.Item ><div data-path="/contact" onClick={goToPage}>Contact</div></NavDropdown.Item>
									</NavDropdown> */}
								</Nav>
								<Form className="d-flex">
									<Form.Control type="search" ref={searchTitle} name="searchPara" placeholder="Search" className="me-2" aria-label="Search" onKeyDown={(e) => {
										if (e.key === "Enter") {
											e.preventDefault();
											getRequested();
										}
									}} />
									<Button variant="outline-success" onClick={getRequested}>Search</Button>
								</Form>
							</Offcanvas.Body>
						</Navbar.Offcanvas>
					</Container>
				</Navbar>
			))}
		</Fragment>
	);
}

export { Header, ResponsiveHeader };

