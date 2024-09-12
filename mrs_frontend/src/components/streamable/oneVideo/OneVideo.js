import { Fragment, useState } from 'react';
import ReactPlayer from 'react-player';
import ResponsiveFooter from '../../footer/ResponsiveFooter';
import './OneVideo.css';
// import { LazyLoadImage } from 'react-lazy-load-image-component';

function OneVideo({ details }) {
	const [FullImage, setFullImage] = useState(null);

	const showFullImg = (e) => {
		setFullImage(e.currentTarget.src)
	}
	return (
		<Fragment>
			<main>
				<div className="watchableTitle">{details.title}</div>
				<div className='details'>
					<div className='details-details'>
						<section className='genres'><span className='genresTitle'>Genres</span> <span className='genresNames'>{details.genres.join(", ")}</span></section>
						<article>
							<article className='sectionHeading'>Reviews</article>
							<div className='eachMovie_Details_Reviews'>
								{(details.reviewIds) ? details.reviewIds.map((r, index) => {
									return ((index < 7) ? <div className='eachReview' key={r.id.timestamp}>{index + 1}). {r.body}</div> : null);
								}).concat((details.reviewIds.length > 8) ? "..." : "") : ""}
							</div>
						</article>
						<div className='details-releaseDate'>{details.releaseDate}</div>
					</div>
					<img className='details-poster' src={details.poster} alt={`${details.title} poster`} onClick={(e) => showFullImg(e)} />
				</div>
				<div className='eachMovie_Details_SS'>
					{(details.backdrops) ?
						<><h3>Samples</h3>
							{details.backdrops.map((link, index) => {
								return (<div className='eachSS' key={link}>
									<img loading="lazy" src={link} alt={`Screenshot ${index + 1} `} onClick={(e) => showFullImg(e)} />
									{/* <LazyLoadImage  loading="lazy" src={link} alt={`Screenshot ${index + 1} `} /> */}
								</div>);
							})}
						</> : ""}
				</div>
				{(details.trailerLink ?
					<>
						<article className='sectionHeading'>Trailer</article>
						<div className='trailerArea'>
							<ReactPlayer controls="true" playing={false} url={details.trailerLink} width="100%" height='100%' />
						</div>
					</>
					: null)}
				{FullImage ? <div className='fullPage'>
					<span className='fullImageCloseBtn' onClick={() => setFullImage(null)}>X</span>
					<img loading="lazy" src={FullImage} alt="Screenshot fullSS" style={{ height: "80%", maxWidth: "80%" }} />
				</div> : null}
				<ResponsiveFooter />
			</main>
		</Fragment >
	)
}

export default OneVideo